package com.example.foodtower

class InformationWidget {
    /*var menu_satu = food_menu1()
    var judul_satu = menu_satu.menumakanan.text*/
    private var listMenu = arrayListOf(
        "Ayam Goreng\nLorem ipsum dolor sit amet, consectetuer adipiscing elit." +
                "Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies," +
                "purus lectus malesuada libero, sit amet commodo magna eros quis urna.",
        "Ikan Panggang\nLorem ipsum dolor sit amet, consectetuer adipiscing elit." +
                "Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies," +
                "purus lectus malesuada libero, sit amet commodo magna eros quis urna.",
        "Rendang Ayam\nLorem ipsum dolor sit amet, consectetuer adipiscing elit." +
                "Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies," +
                "purus lectus malesuada libero, sit amet commodo magna eros quis urna.",
        /*"${judul_satu}"*/
    )
    private var index = -1
    fun addMenu(str: String) {
        listMenu.add(str)
    }
    fun removeMenu(str: String) {
        listMenu.remove(str)
    }
    fun backToStart() {
        index = -1
    }
    fun getMenu() : String {
        if(listMenu.size == 0) return "Kosong"
        if(index+1 == listMenu.size) backToStart()
        index += 1
        return listMenu.get(index)
    }
}