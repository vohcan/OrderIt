package com.vohcan.orderit.model;


import com.vohcan.orderit.R;

public class Table {
    private String name;
    private int idDrawable;

    public Table(String name, int idDrawable) {
        this.name = name;
        this.idDrawable = idDrawable;
    }

    public String getName() {
        return name;
    }

    public int getidDrawable() {
        return idDrawable;
    }



    public int getId(){
        return name.hashCode();
    }

    public static Table [] items = {
         new Table("Mesa 1", R.drawable.mesa_bg),
         new Table("Mesa 2", R.drawable.mesa_bg),
         new Table("Mesa 3", R.drawable.mesa_bg),
         new Table("Mesa 4", R.drawable.mesa_bg),
         new Table("Mesa 5", R.drawable.mesa_bg),
         new Table("Mesa 6", R.drawable.mesa_bg),
         new Table("Mesa 7", R.drawable.mesa_bg),
         new Table("Mesa 8", R.drawable.mesa_bg),
    };


    public static Table getItem (int id){
        for (Table item :items){
            if(item.getId()== id){
                return item;
            }
        }
        return null;
    }
}
