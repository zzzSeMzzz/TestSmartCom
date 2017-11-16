Ext.define('SC.view.ItemListC' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.itemlistc',

    title: 'Каталог товаров',
    renderTo: Ext.get('mainView'),
    store: 'ItemStore',

    initComponent: function() {

        this.columns = [
            {header: 'Название',  dataIndex: 'name',  flex: 1},
            {header: 'Категория',  dataIndex: 'category',  flex: 1},
            {header: 'Цена', dataIndex: 'price', flex: 1},
            {header: 'Код', dataIndex: 'code', flex: 1}
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
                itemId: 'basket',
                text: 'В корзину',
                action: 'basket'
            }]
        },
            {
                xtype: 'pagingtoolbar',
                dock:'top',
                store: 'ItemStore',
                displayInfo: true,
                displayMsg: 'Список товаров {0} - {1} из {2}',
                emptyMsg: "Нет товаров для отображения"
            }];

        this.callParent(this.arguments);
    }
});