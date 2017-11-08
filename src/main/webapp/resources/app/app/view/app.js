Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'SC',
    appFolder: '../../resources/app/app',

    controllers: ['Items', 'Customers'],
    stores: ['ItemStore', 'CustomerStore'],
    views: ['ItemList', 'EditItem', 'CustomerList', 'EditCustomer'],

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