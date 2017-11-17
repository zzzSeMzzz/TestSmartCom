Ext.define('SC.model.Order', {
    extend: 'Ext.data.Model',
    fields: ['id', 'customerName', 'orderDate', 'shipmentDate', 'orderNumber', 'status', 'customerId']
});