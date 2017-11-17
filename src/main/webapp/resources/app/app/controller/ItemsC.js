Ext.define('SC.controller.ItemsC', {
    extend: 'Ext.app.Controller',

    views: ['ItemListC'],

    models: ['Item'],

    stores: ['ItemStore'],

    refs: [{
        ref: 'itemsPanel',
        selector: 'panel'
    },{
        ref: 'itemlistc',
        selector: 'itemlistc'
    }
    ],


        init: function() {
            this.control({
                'viewport > itemlistc': {

                },
                'itemlistc button[action=basket]': {
                    click: this.addToBasket
                }
            });
        },

    

    addToBasket: function(button) {
        var grid = this.getItemlistc(),
            record = grid.getSelectionModel().getSelection();
            //store = this.getStore('ItemStore');
        if (record.length>0)   {
            console.log(record[0].raw.id);
            Ext.Ajax.request({
                url: 'addtobasket/?id='+record[0].raw.id,
                success:'success',
                success: function(response, options){
                    var json = Ext.decode(response.responseText);
                    console.log(json);
                    Ext.MessageBox.alert('Успешно.','Товар добален в корзину');

                },
                failure: function(response, options){
                    alert("Ошибка: " + response.responseText);
                }
            });
        }
    }
});