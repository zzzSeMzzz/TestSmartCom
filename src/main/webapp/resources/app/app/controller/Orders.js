Ext.define('SC.controller.Orders', {
    extend: 'Ext.app.Controller',

    views: ['OrderList'],

    models: ['Order'],

    stores: ['OrderStore'],

    refs: [{
        ref: 'orderlist',
        selector: 'orderlist'
    }
    ],


        init: function() {
            this.control({
                'viewport > orderlist': {

                },
                'orderlist dataview': {
                    //itemdblclick: this.editItem
                },
                'customeredit button[action=save]': {
                    //click: this.updateItem
                },
                'orderlist button[action=delete]': {
                    click: this.deleteItem
                }
            });
        },


    editItem: function(grid, record) {
        var edit = Ext.create('SC.view.EditCustomer').show();
        //console.log(record);

        if(record){
            edit.down('form').loadRecord(record);
        }
    },
    

    deleteItem: function(button) {
        var grid = this.getOrderlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('OrderStore');

        if (record.length>0) {
            console.log(record[0].raw.status);
            if(record[0].raw.status=='NEW'){
                store.remove(record);
                store.sync();
            }else{
                Ext.MessageBox.alert('Ошибка.','Можно удалить заказ только со статусом NEW');
            }
        }
    }
});