Ext.define('SC.controller.Items', {
    extend: 'Ext.app.Controller',

    views: ['ItemList', 'EditItem'],

    models: ['Item'],

    stores: ['ItemStore'],

    refs: [{
        ref: 'itemsPanel',
        selector: 'panel'
    },{
        ref: 'itemlist',
        selector: 'itemlist'
    }
    ],


        init: function() {
            this.control({
                'viewport > itemlist': {

                },
                'itemlist button[action=add]': {
                    click: this.editItem
                },
                'itemlist dataview': {
                    itemdblclick: this.editItem
                },
                'itemedit button[action=save]': {
                    click: this.updateItem
                },
                'itemlist button[action=delete]': {
                    click: this.deleteItem
                }
            });
        },


    editItem: function(grid, record) {
        var edit = Ext.create('SC.view.EditItem').show();
        //console.log(record);

        if(record){
            edit.down('form').loadRecord(record);
        }
    },

    updateItem: function(button) {
        console.log('update user try');
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        console.log(values.id);

        if (values.id > 0){
            console.log('now update user');
            record.set(values);
        } else{
            console.log('now create user');
            record = Ext.create('SC.model.Item');

            record.set(values);
            //record.set('id', '0');
            //console.log(values);
            this.getStore('ItemStore').add(record);
        }

        win.close();
        this.getStore('ItemStore').sync();
    },

    deleteItem: function(button) {
        var grid = this.getItemlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('ItemStore');

        store.remove(record);
        this.getStore('ItemStore').sync();
    }
});