Ext.define('SC.view.Item', {
    extend: 'Ext.window.Window',
    alias: 'widget.itemwindow',

    title: 'Тофар',
    layout: 'fit',
    autoShow: true,

    initComponent: function() {
        this.items = [{
            xtype: 'form',
            items: [{
                xtype: 'textfield',
                name : 'name',
                fieldLabel: 'Название'
            },{
                xtype: 'textfield',
                name : 'category',
                fieldLabel: 'Категория'
            },{
                xtype: 'numberfield',
                name : 'price',
                fieldLabel: 'Цена',
                minValue: 1,
            },{
                xtype: 'textfield',
                name : 'code',
                fieldLabel: 'Код',
                minValue: 1,
            }
            ]
        }];
        this.dockedItems=[{
            xtype:'toolbar',
            docked: 'top',
            items: [{
                text:'Создать',
                iconCls:'new-icon',
                action: 'new'
            },{
                text:'Сохранить',
                iconCls:'save-icon',
                action: 'save'
            },{
                text:'Удалить',
                iconCls:'delete-icon',
                action: 'delete'
            }]
        }];
        this.buttons = [{
            text: 'Очистить',
            scope: this,
            action: 'clear'
        }];

        this.callParent(arguments);
    }
});