Ext.define('SC.view.EditOrder', {
    extend: 'Ext.window.Window',
    alias : 'widget.orderedit',

    requires: ['Ext.form.Panel','Ext.form.field.Text', 'Ext.form.field.ComboBox', 'Ext.form.field.Date'],
    modal:true,
    title : 'Редактирование заказа',
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
                        xtype: 'datefield',
                        name : 'shipmentDate',
                        id : 'shipmentDate',
                        format: 'Y-m-d',
                        fieldLabel: 'Дата доставки'
                    },
                    {
                        xtype: 'combobox',
                        name : 'status',
                        fieldLabel: 'Статус',
                        store: 'StatusStore',
                        displayField:'status',
                        valueField:'status',
                        editable: false,
                        queryMode: 'local',
                        value: 'NEW',

                        /*listeners: {
                            change: function (field, newValue, oldValue) {
                                console.log(field.getRawValue());
                                Ext.getCmp('roleField').setValue(field.getRawValue());
                            },
                            scope: this
                        }*/
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
