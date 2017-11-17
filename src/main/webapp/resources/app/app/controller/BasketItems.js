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
                    click: this.showOrder
                },
                'basketlist button[action=delete]': {
                    click: this.deleteItem
                },
                'createorder button[action=saveo]': {
                    click: this.saveOrder
                }
            });
        },
    

    deleteItem: function(button) {
        var grid = this.getBasketlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('SimpleBasketStore');

        store.remove(record);
        store.sync();
    },

    showOrder: function(button) {
       /*var grid = this.getBasketlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('SimpleBasketStore');*/
        var newOrder = Ext.create('SC.view.CreateOrder').show();
    },

    saveOrder: function(button) {
        console.log('try save order');
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues(),
            store = this.getStore('SimpleBasketStore');
        console.log(values);
        if(values.order_date=="" || values.order_number==""){
            Ext.MessageBox.alert('Ошибка.','Поля даты и номер не могут быть пустыми');
            return;
        }

        //var jsonRequest = Ext.encode(record);

        Ext.Ajax.request({
            url: 'createorder/',
            method: 'POST',
            jsonSubmit: true,
            jsonData: Ext.encode(values),

            success: function(response, options){
                var json = Ext.decode(response.responseText);
                console.log(json);
                Ext.MessageBox.alert('Успешно.','Заказ создан');
                store.removeAll();
                store.sync();

            },
            failure: function(response, options){
                alert("Ошибка: " + response.responseText);
            }
        });

        win.close();//закрывает оно оформления заказа
    }
});