Ext.application({
    name: 'PhonesDir',
    appFolder: 'app',
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'panel',
                html: '<h2>This is test extjs</h2>'
            }
        });
    }
});