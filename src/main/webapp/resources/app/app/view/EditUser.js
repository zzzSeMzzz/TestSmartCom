Ext.define('SC.view.EditUser', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',

    requires: ['Ext.form.Panel','Ext.form.field.Text', 'Ext.form.field.ComboBox'],
    modal:true,
    title : 'Редактирование пользователя',
    layout: 'fit',
    autoShow: true,
    width: 280,
    


    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side'
                },

                items: [
                    {
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'id',
                        hidden:true
                    },
                    {
                        xtype: 'textfield',
                        name : 'role',
                        id:'roleField',
                        fieldLabel: 'Название роли',
                        readOnly: true,
                        hidden:true,
                        value: 'ROLE_MANAGER'
                    },
                    {
                        xtype: 'textfield',
                        name : 'nameCustomer',
                        id:'nameCustomer',
                        fieldLabel: 'Имя заказчика',
                        readOnly: true,
                        hidden:true
                    },
                    {
                        xtype: 'textfield',
                        name : 'login',
                        fieldLabel: 'Логин'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password',
                        fieldLabel: 'Пароль'
                    },
                    {
                        xtype: 'combobox',
                        name : 'idRole',
                        fieldLabel: 'Роль',
                        store: 'RoleStore',
                        displayField:'role',
                        valueField:'id',
                        editable: false,
                        queryMode: 'local',
                        value: 0,
                        listeners: {
                            change: function (field, newValue, oldValue) {
                                console.log(field.getRawValue());
                                Ext.getCmp('roleField').setValue(field.getRawValue());
                            },
                            scope: this
                        }
                    },
                    {
                        xtype: 'combobox',
                        name : 'idCustomer',
                        fieldLabel: 'Заказчик',
                        store: 'CustomerStore',
                        displayField:'name',
                        valueField:'id',
                        editable: false,
                        listeners: {
                            change: function (field, newValue, oldValue) {
                                console.log(field.getRawValue());
                                Ext.getCmp('nameCustomer').setValue(field.getRawValue());
                            },
                            scope: this
                        }
                    }
                ]
            }
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons',
            ui: 'footer',
            items: ['->', {
                itemId: 'save',
                text: 'Сохранить',
                action: 'save'
            },{
                text: 'Отмена',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});
