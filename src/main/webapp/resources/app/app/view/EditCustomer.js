Ext.define('SC.view.EditCustomer', {
    extend: 'Ext.window.Window',
    alias : 'widget.customeredit',

    requires: ['Ext.form.Panel','Ext.form.field.Text'],
    modal:true,
    title : 'Редактирование заказчика',
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
                        name : 'name',
                        fieldLabel: 'Имя'
                    },
                    {
                        xtype: 'textfield',
                        name : 'code',
                        fieldLabel: 'Код'
                    },
                    {
                        xtype: 'textfield',
                        name : 'address',
                        fieldLabel: 'Адрес'
                    },
                    {
                        xtype: 'textfield',
                        maskRe: /[0-9.]/,
                        name : 'discount',
                        fieldLabel: 'Скидка, %'
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
