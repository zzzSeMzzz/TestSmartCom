Ext.define('SC.view.CustomerList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.customerlist',

    title: 'Заказчики',
    store: 'CustomerStore',

    initComponent: function() {

        this.columns = [
            {header: 'Имя',  dataIndex: 'name',  flex: 1},
            {header: 'Адрес',  dataIndex: 'address',  flex: 1},
            {header: 'Код', dataIndex: 'code', flex: 1},
            {header: 'Скидка, %', dataIndex: 'discount', flex: 1}
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
                store: 'CustomerStore',
                displayInfo: true,
                displayMsg: 'Список заказчиков {0} - {1} из {2}',
                emptyMsg: "Нет заказчиков для отображения"
            }];

        this.callParent(this.arguments);
    }
});