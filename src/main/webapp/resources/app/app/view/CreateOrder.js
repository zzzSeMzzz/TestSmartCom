Ext.define('SC.view.CreateOrder', {
    extend: 'Ext.window.Window',
    alias : 'widget.createorder',

    requires: ['Ext.form.Panel','Ext.form.field.Text', 'Ext.form.field.Date'],
    modal:true,
    title : 'Создание заказа',
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
                        id : 'id',
                        fieldLabel: 'id',
                        hidden:true,
                        value: 'null'
                    },
                    {
                        xtype: 'textfield',
                        name : 'orderNumber',
                        id : 'orderNumber',
                        maskRe: /[0-9.]/,
                        fieldLabel: 'Номер заказа'
                    },
                    {
                        xtype: 'textfield',
                        name : 'status',
                        fieldLabel: 'Статус',
                        readOnly: true,
                        value: 'NEW'
                    },
                    {
                        xtype: 'datefield',
                        name : 'orderDate',
                        id : 'orderDate',
                        format: 'Y-m-d',
                        fieldLabel: 'Дата заказа',
                        value: new Date()
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
                itemId: 'saveo',
                text: 'Создать заказ',
                action: 'saveo'
            },{
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});
