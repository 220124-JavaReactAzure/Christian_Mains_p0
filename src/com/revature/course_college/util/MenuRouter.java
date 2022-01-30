package com.revature.course_college.util;

import com.revature.course_college.menus.Menu;

public class MenuRouter {
	
	protected LinkedList<Menu> menuRouter;
	
	public MenuRouter() {
		
		this.menuRouter = new LinkedList<Menu>();
		
	}
	
	public boolean add(Menu menu) {
		
		return this.menuRouter.add(menu);
		
	}
	
	public void transfer(String rout) throws Exception {
		//System.out.println("menuRouter.transfer has been called");
		for(int i = 0; i < this.menuRouter.getSize(); i++) {
			Menu menu = menuRouter.get(i);
			if(menu.getRout().equals(rout)) {
				menu.render();
			}
		}
	}

}
