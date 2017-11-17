Ext.define('SC.controller.OrdersAdmin', {
    extend: 'Ext.app.Controller',

    views: ['OrderListAdmin', 'EditOrder'],

    models: ['Order'],

    stores: ['OrderStore'],

    refs: [{
        ref: 'orderlistadmin',
        selector: 'orderlistadmin'
    }
    ],


        init: function() {
            this.control({
                'viewport > orderlistadmin': {

                },
                'orderlistadmin dataview': {
                    itemdblclick: this.editItem
                },
                'orderedit button[action=save]': {
                    click: this.updateItem
                }
            });
        },

    updateItem: function(button) {
        console.log('update order try');
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        //console.log('id='+values.id);

        if (values.id > 0){
            console.log(values);
            record.set(values);
        } /*else{
            console.log('now create customer');
            record = Ext.create('SC.model.Customer');

            record.set(values);
            this.getStore('CustomerStore').add(record);
        }*/

        win.close();
        this.getStore('OrderStore').sync();
    },

    editItem: function(grid, record) {
        var edit = Ext.create('SC.view.EditOrder').show();
        //console.log(record);

        if(record){
            edit.down('form').loadRecord(record);
        }
    }
    

   
});