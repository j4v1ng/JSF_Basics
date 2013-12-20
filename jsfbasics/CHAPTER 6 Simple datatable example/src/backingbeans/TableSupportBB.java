package backingbeans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import beans.Thing;

@Named("tableSupportBB")
@RequestScoped
public class TableSupportBB {

		private List<Thing> things;
		
		
		public TableSupportBB() {
			things = new ArrayList<Thing>();
			things.add(new Thing("Apple", "Its a fruit", 2));
			things.add(new Thing("Plane", "Used to travel", 1000));
			things.add(new Thing("Human", "Rare live form", 66));
			things.add(new Thing("Planet", "Something really big", 12364));
			things.add(new Thing("Book", "Lots of fun", -99));
		}


		public List<Thing> getThings() {
			return things;
		}


		public void setThings(List<Thing> things) {
			this.things = things;
		}	
		
		public String refresh() {
			return null;
		}
}
