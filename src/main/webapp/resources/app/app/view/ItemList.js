Ext.define('SC.view.ItemList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.itemlist',

    title: 'Товары',
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
                itemId: 'add',
                text: 'Добавить',
                action: 'add'
            },{
                text: 'Удалить',
                action: 'delete'
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