Ext.define('SC.controller.Users', {
    extend: 'Ext.app.Controller',

    views: ['UserList', 'EditUser'],

    models: ['User'],

    stores: ['UserStore', 'RoleStore'],

    refs: [{
        ref: 'itemsPanel',
        selector: 'panel'
    },{
        ref: 'userlist',
        selector: 'userlist'
    }
    ],


        init: function() {
            this.control({
                'viewport > userlist': {

                },
                'userlist button[action=add]': {
                    click: this.editItem
                },
                'userlist dataview': {
                    itemdblclick: this.editItem
                },
                'useredit button[action=save]': {
                    click: this.updateItem
                },
                'userlist button[action=delete]': {
                    click: this.deleteItem
                }
            });
        },


    editItem: function(grid, record) {
        var edit = Ext.create('SC.view.EditUser').show();
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

        console.log(values);

        if(values.role=="ROLE_CUSTOMER" && values.idCustomer ==""){
            Ext.MessageBox.alert('Ошибка сохранения','Для ROLE_CUSTOMER должен быть установлен заказчик');
            return;
        }

        if (values.id > 0){
            console.log('now update user');
            record.set(values);
        } else{
            console.log('now create user');
            record = Ext.create('SC.model.User');

            record.set(values);
            this.getStore('UserStore').add(record);
        }

        win.close();
        this.getStore('UserStore').sync();
    },

    deleteItem: function(button) {
        var grid = this.getUserlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getStore('UserStore');

        store.remove(record);
        this.getStore('UserStore').sync();
    }
});