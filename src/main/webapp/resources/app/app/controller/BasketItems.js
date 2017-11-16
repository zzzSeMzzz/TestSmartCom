Ext.define('SC.controller.BasketItems', {
    extend: 'Ext.app.Controller',

    views: ['SimpleBasketList'],

    models: ['SimpleBasket'],

    stores: ['SimpleBasketStore'],

    refs: [{
        ref: 'itemsPanel',
        selector: 'panel'
    },{
        ref: 'basketlist',
        selector: 'basketlist'
    }
    ],


        init: function() {
            this.control({
                'viewport > basketlist': {

                },
                'basketlist button[action=order]': {
                    //click: this.editItem
                },
                'basketlist button[action=delete]': {
                    click: this.deleteItem
                }
            });
        },
    

    deleteItem: function(button) {
        var grid = this.getBasketlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('SimpleBasketStore');

        store.remove(record);
        this.getStore('SimpleBasketStore').sync();
    }
});