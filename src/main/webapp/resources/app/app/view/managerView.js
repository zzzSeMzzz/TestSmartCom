Ext.onReady(function(){

    var toolBar = Ext.create('Ext.toolbar.Toolbar', {
        width   : '100pct',
        height: '100pct',
        items: [
            {
                text: 'Управление заказами',
                handler: function() {
                    btnShowOrders();
                }
            },'-',
            {
                text: 'Управление товарами',
                handler: function() {
                    btnManageItems();
                }
            },'-',
            {
                text: 'Заказчики',
                handler: function() {
                    btnManageCustomers();
                }
            },'-',
            {
                text : 'Управление пользователями',
                handler: function() {
                    btnManageUsers();
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

    function btnShowOrders() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Управление заказами',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'orderlistadmin'
            }]
        });

        Ext.getCmp('orderlistadmin').getStore('OrderStore').load();
        window.show();
    }

    function btnManageItems() {
        var window = Ext.create('Ext.window.Window', {
            title: 'Редактирование товаров',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'itemlist'
            }]
        });
        /*viewPort.add({
            window
        });*/
        window.show();

    }

    function btnManageCustomers(){
        var window = Ext.create('Ext.window.Window', {
            title: 'Управление заказчиками',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'customerlist'
            }]
        });
        window.show();
    }

    function btnManageUsers(){
        var window = Ext.create('Ext.window.Window', {
            title: 'Редактирвоание пользователей',
            width: Ext.getBody().getViewSize().width*0.75,
            height: Ext.getBody().getViewSize().width*0.35,
            items:[{
                xtype: 'userlist'
            }]
        });
        window.show();
    }
});

