Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'SC',
    appFolder: '../../resources/app/app',

    controllers: ['Items', 'Customers', 'Users'],
    stores: ['ItemStore', 'CustomerStore', 'UserStore', 'RoleStore'],
    views: ['ItemList', 'EditItem', 'CustomerList', 'EditCustomer', 'UserList'],

    launch: function() {
        console.log('start extjs app');
       /* Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'itemlist'
            }
        });*/
    }
});