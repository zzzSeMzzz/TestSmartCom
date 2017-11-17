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
                    btnShowOrders();
                }
            },'-',
            {
                text: 'Корзина',
                handler: function() {
                    btnShowBasket();
                }
            },'->',
            {
                text : 'Logout',
                handler: function() {
                    window.location.replace('/logout');
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

    function btnShowOrders() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Мои заказы',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'orderlist'
            }]
        });

        Ext.getCmp('orderlist').getStore('OrderStore').load();
        window.show();
    }

});

