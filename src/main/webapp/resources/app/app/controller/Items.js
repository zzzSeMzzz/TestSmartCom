Ext.define('SC.controller.Items', {
    extend: 'Ext.app.Controller',

    views: ['ItemList', 'Item', 'EditItem'],

    models: ['Item'],

    stores: ['ItemStore'],

    refs: [{
        ref: 'contactsPanel',
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
                    click: this.editUser
                },
                'itemlist dataview': {
                    itemdblclick: this.editUser
                },
                'itemedit button[action=save]': {
                    click: this.updateUser
                },
                'itemwindow button[action=delete]': {

                }
            });
        },

    clearForm: function(grid, record) {
        var view = Ext.widget('bookwindow');
        view.down('form').getForm().reset();
    },

    editUser: function(grid, record) {
        var edit = Ext.create('SC.view.EditItem').show();
        //console.log(record);

        if(record){
            edit.down('form').loadRecord(record);
        }
    },

    updateUser: function(button) {
        console.log('update user try');
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();


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
    }
});