Ext.define('SC.view.SimpleBasketList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.basketlist',
    id:'basketlist',
    title: 'Корзина',
    store: 'SimpleBasketStore',

    initComponent: function() {

        this.columns = [
            {header: 'Товар',  dataIndex: 'itemName',  flex: 1},
            {header: 'Количество',  dataIndex: 'count',  flex: 1},
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
                itemId: 'order',
                text: 'Оформмить заказ',
                action: 'order'
            },{
                text: 'Удалить',
                action: 'delete'
            }]
        },
            {
                xtype: 'pagingtoolbar',
                dock:'top',
                store: 'SimpleBasketStore',
                displayInfo: true,
                displayMsg: 'Товары в корзине {0} - {1} из {2}',
                emptyMsg: "Нет товаров для отображения"
            }];

        this.callParent(this.arguments);
    }
});