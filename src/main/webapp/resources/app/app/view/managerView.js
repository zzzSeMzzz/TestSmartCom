Ext.onReady(function(){

    var toolBar = Ext.create('Ext.toolbar.Toolbar', {
        width   : '100pct',
        height: '100pct',
        items: [
            {
                text: 'Управление заказами',
                handler: function() {
                    btn1();
                }
            },'-',
            {
                text: 'Управление товарами',
                handler: function() {
                    btnManageItems();
                }
            },'-',
            {
                text : 'Управление пользователями'
            }
        ]
    });

    var viewPort = Ext.create('Ext.container.Viewport', {
        items: [ toolBar ]
    });

    function btn1() {
        Ext.MessageBox.alert('Авторизация пройдена.','dd');
    }

    function btnManageItems() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Редактирование товаров',
            width: '80pct',
            height: 500,
            items:[{
                xtype: 'itemlist'
            }]
        });
        /*viewPort.add({
            window
        });*/
        window.show();

    }

});

