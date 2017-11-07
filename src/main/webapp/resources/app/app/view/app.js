Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'SC',
    appFolder: '../../resources/app/app',

    controllers: ['Items'],
    stores: ['ItemStore'],
    views: ['Item', 'SC.view.ItemList'],

    launch: function() {
        console.log('dfdf');
       /* Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'itemlist'
            }
        });*/
    }
});