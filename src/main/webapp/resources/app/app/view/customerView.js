Ext.onReady(function(){

    var toolBar = Ext.create('Ext.toolbar.Toolbar', {
        width   : '100pct',
        height: '100pct',
        items: [
            {
                text: 'Каталог товаров',
                handler: function() {
                    btnGetOrders();
                }
            },'-',
            {
                text: 'Мои заказы',
                handler: function() {
                    //btnManageItems();
                }
            },'-',
            {
                text: 'Корзина',
                handler: function() {
                    btnShowBasket();
                }
            }
        ]
    });

    var viewPort = Ext.create('Ext.container.Viewport', {
        items: [ toolBar ]
    });

    function btnGetOrders() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Товары',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'itemlistc'
            }]
        });
        window.show();
    }

    function btnShowBasket() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Товары',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'basketlist'
            }]
        });
        
        Ext.getCmp('basketlist').getStore('SimpleBasketStore').load();
        window.show();
    }

});

