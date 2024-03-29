package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebFilter(urlPatterns = "/upload/*", initParams = { @WebInitParam(name = "com.corejsf.UploadFilter.sizeThreshold", value = "1024") })
public class UploadFilter implements Filter {

	private int sizeThreshold = -1;
	private String repositoryPath;

	public void init(FilterConfig config) throws ServletException {
		repositoryPath = config
				.getInitParameter("com.corejsf.UploadFilter.repositoryPath");
		try {
			String paramValue = config
					.getInitParameter("com.corejsf.UploadFilter.sizeThreshold");
			if (paramValue != null) {
				sizeThreshold = Integer.parseInt(paramValue);
			}
		} catch (NumberFormatException ex) {
			ServletException servletEx = new ServletException();
			servletEx.initCause(ex);
			throw servletEx;
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(httpRequest);

		if (!isMultipartContent) {
			// If the form is multipart(Not just a file-also text from a
			// field...)
			chain.doFilter(request, response);
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		if (sizeThreshold >= 0) {
			factory.setSizeThreshold(sizeThreshold);
		}
		if (repositoryPath != null) {
			factory.setRepository(new File(repositoryPath));
		}
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = (List<FileItem>) upload
					.parseRequest(httpRequest);
			final Map<String, String[]> map = new HashMap<String, String[]>();
			for (FileItem item : items) {
				String str = item.getString();
				if (item.isFormField()) {
					map.put(item.getFieldName(), new String[] { str });
				} else {
					httpRequest.setAttribute(item.getFieldName(), item);
				}
			}

			chain.doFilter(new HttpServletRequestWrapper(httpRequest) {
				public Map<String, String[]> getParameterMap() {
					return map;
				}

				public String[] getParameterValues(String name) {
					Map<String, String[]> map = getParameterMap();
					return (String[]) map.get(name);
				}

				public String getParameter(String name) {
					String[] params = getParameterValues(name);
					if (params == null) {
						return null;
					}
					return params[0];
				}

				public Enumeration<String> getParameterNames() {
					Map<String, String[]> map = getParameterMap();
					return Collections.enumeration(map.keySet());
				}
			}, response);
		} catch (FileUploadException ex) {
			ServletException servletEx = new ServletException();
			servletEx.initCause(ex);
			throw servletEx;
		}
	}
}
