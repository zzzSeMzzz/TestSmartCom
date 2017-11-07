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

        this.callParent(this.arguments);
    }
});