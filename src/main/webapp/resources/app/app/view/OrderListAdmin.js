Ext.define('SC.view.OrderListAdmin' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.orderlistadmin',
    id:'orderlistadmin',
    title: 'Заказы',
    store: 'OrderStore',



    initComponent: function() {

           this.filters = [
                {
                    type: 'string',
                    dataIndex: 'status',
                }
            ];


            this.columns = [
            {header: 'Заказчик',  dataIndex: 'customerName',  flex: 1},
            {header: 'Дата заказа',  dataIndex: 'orderDate',  flex: 1},
            {header: 'Дата доставки', dataIndex: 'shipmentDate', flex: 1},
            {header: 'Номер заказа', dataIndex: 'orderNumber', flex: 1},
            {header: 'Статус', dataIndex: 'status', flex: 1}
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            items: []
        },
            {
                xtype: 'pagingtoolbar',
                dock:'top',
                store: 'OrderStore',
                displayInfo: true,
                displayMsg: 'Список заказов {0} - {1} из {2}',
                emptyMsg: "Нет заказов для отображения"
            }];

        this.callParent(this.arguments);
    }
});