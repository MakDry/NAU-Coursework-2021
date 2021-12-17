package PL;

import BLL.World;

public class Program {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        World world = new World();

        Menu menu = new Menu(world, view);
        menu.menuController();
    }
}
