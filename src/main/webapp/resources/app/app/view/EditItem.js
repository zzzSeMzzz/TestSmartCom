Ext.define('SC.view.EditItem', {
    extend: 'Ext.window.Window',
    alias : 'widget.itemedit',

    requires: ['Ext.form.Panel','Ext.form.field.Text'],
    modal:true,
    title : 'Редактирование товара',
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
                        fieldLabel: 'Название'
                    },
                    {
                        xtype: 'textfield',
                        name : 'code',
                        fieldLabel: 'Код'
                    },
                    {
                        xtype: 'textfield',
                        name : 'category',
                        fieldLabel: 'Категория'
                    },
                    {
                        xtype: 'textfield',
                        maskRe: /[0-9.]/,
                        name : 'price',
                        fieldLabel: 'Цена'
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
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});
