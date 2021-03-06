/**
 * @author Ed Spencer
 * @class Ext.data.writer.Xml
 * @extends Ext.data.writer.Writer
 * 
 * <p>Writer that outputs model data in XML format</p>
 */
Ext.define('Ext.data.writer.Xml', {
    
    /* Begin Definitions */
    
    extend: 'Ext.data.writer.Writer',
    alternateClassName: 'Ext.data.XmlWriter',
    
    alias: 'writer.xml',
    
    /* End Definitions */
    
    /**
     * @cfg {String} documentRoot The name of the root element of the document. Defaults to <tt>'xmlData'</tt>.
     * If there is more than 1 record and the root is not specified, the default document root will still be used
     * to ensure a valid XML document is created.
     */
    documentRoot: 'xmlData',
    
    /**
     * @cfg {String} defaultDocumentRoot The root to be used if {@link #documentRoot} is empty and a root is required
     * to form a valid XML document.
     */
    defaultDocumentRoot: 'xmlData',

    /**
     * @cfg {String} header A header to use in the XML document (such as setting the encoding or version).
     * Defaults to <tt>''</tt>.
     */
    header: '',

    /**
     * @cfg {String} record The name of the node to use for each record. Defaults to <tt>'record'</tt>.
     */
    record: 'record',

    //inherit docs
    writeRecords: function(request, data) {
        var me = this,
            xml = [],
            i = 0,
            len = data.length,
            root = me.documentRoot,
            record = me.record,
            needsRoot = data.length !== 1,
            item,
            key;
            
        // may not exist
        xml.push(me.header || '');
        
        if (!root && needsRoot) {
            root = me.defaultDocumentRoot;
        }
        
        if (root) {
            xml.push('<', root, '>');
        }
            
        for (; i < len; ++i) {
            item = data[i];
            xml.push('<', record, '>');
            for (key in item) {
                if (item.hasOwnProperty(key)) {
                    xml.push('<', key, '>', item[key], '</', key, '>');
                }
            }
            xml.push('</', record, '>');
        }
        
        if (root) {
            xml.push('</', root, '>');
        }
            
        request.xmlData = xml.join('');
        return request;
    }
});
