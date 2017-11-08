Ext.define('SC.controller.Customers', {
    extend: 'Ext.app.Controller',

    views: ['CustomerList', 'EditCustomer'],

    models: ['Customer'],

    stores: ['CustomerStore'],

    refs: [{
        ref: 'itemsPanel',
        selector: 'panel'
    },{
        ref: 'customerlist',
        selector: 'customerlist'
    }
    ],


        init: function() {
            this.control({
                'viewport > customerlist': {

                },
                'customerlist button[action=add]': {
                    click: this.editItem
                },
                'customerlist dataview': {
                    itemdblclick: this.editItem
                },
                'customeredit button[action=save]': {
                    click: this.updateItem
                },
                'customerlist button[action=delete]': {
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

    updateItem: function(button) {
        console.log('update customer try');
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        //console.log('id='+values.id);

        if (values.id > 0){
            console.log('now update customer');
            record.set(values);
        } else{
            console.log('now create customer');
            record = Ext.create('SC.model.Customer');

            record.set(values);
            this.getStore('CustomerStore').add(record);
        }

        win.close();
        this.getStore('CustomerStore').sync();
    },

    deleteItem: function(button) {
        var grid = this.getCustomerlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('CustomerStore');

        store.remove(record);
        this.getStore('CustomerStore').sync();
    }
});