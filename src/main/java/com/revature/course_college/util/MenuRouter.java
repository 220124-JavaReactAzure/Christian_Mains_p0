package com.revature.course_college.util;

import com.revature.course_college.menus.Menu;

public class MenuRouter {
	
	private final LinkedList<Menu> menuRouter;
	
	public MenuRouter() {
		
		menuRouter = new LinkedList<Menu>();
		
	}
	
	public void add(Menu menu) {
		
		menuRouter.add(menu);
		
	}
	
	public void transfer(String rout) throws Exception {
		for(int i = 0; i < menuRouter.getSize(); i++) {
			Menu menu = menuRouter.get(i);
			if(menu.getRout().equals(rout)) {
				menu.render();
			}
		}
	}

}
