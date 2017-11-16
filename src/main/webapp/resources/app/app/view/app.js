Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'SC',
    appFolder: '../../resources/app/app',

    controllers: ['Items', 'Customers', 'Users', 'ItemsC', 'BasketItems'],
    stores: ['ItemStore', 'CustomerStore', 'UserStore', 'RoleStore', 'SimpleBasketStore'],
    views: ['ItemList', 'EditItem', 'CustomerList', 'EditCustomer', 'UserList', 'ItemListC', 'SimpleBasketList'],

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