Ext.define('SC.view.UserList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.userlist',

    title: 'Подьзователи системы',
    store: 'UserStore',

    initComponent: function() {

        this.columns = [
            {header: 'Логин',  dataIndex: 'login',  flex: 1},
            {header: 'Пароль',  dataIndex: 'password',  flex: 1},
            {header: 'Роль', dataIndex: 'role', flex: 1},
            {header: 'ID заказчика', dataIndex: 'idCustomer', flex: 1, hidden:true},
            {header: 'ID role', dataIndex: 'idRole', flex: 1, hidden:true},
            {header: 'Заказчик', dataIndex: 'nameCustomer', flex: 1}
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
                store: 'UserStore',
                displayInfo: true,
                displayMsg: 'Список пользователей {0} - {1} из {2}',
                emptyMsg: "Нет пользователей для отображения. Необходимо создать пользователя для входа в систему"
            }];

        this.callParent(this.arguments);
    }
});