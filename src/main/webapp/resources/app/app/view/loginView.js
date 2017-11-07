Ext.onReady(function(){

    var loginForm=Ext.create('Ext.form.Panel',{
        title: 'Авторизация',
        width: 300,
        height:150,
        url:'j_spring_security_check',
        bodyPadding:10,
        layout: 'anchor',
        jsonSubmit: false,
        defaults: {
            anchor: '80%'
        },
        renderTo: Ext.getBody(),
        items: [{
            xtype: 'textfield',
            fieldLabel: 'Логин',
            value:'admin',
            name: 'username'
        },
            {
                xtype: 'textfield',
                name: 'password',
                fieldLabel: 'Пароль',
                value:'adm',
                inputType: 'password'
            }],
        buttons: [{
            text: 'Оправить',
            method: 'post',
            handler: function() {
                fnLoginForm(loginForm);
            }
        }]
    });

    loginForm.getEl().center();

    //Submit login and handler response
    function fnLoginForm(theForm) {
        theForm.getForm().submit({
            success: function(form, action) {
                Ext.MessageBox.alert('Авторизация пройдена.',action.result.message);
                window.location.replace('/main/');
            },
            failure: function(form, action) {
                Ext.MessageBox.alert('Ошибка авторизации.', action.result.message);
            }
        });
    } //end fnLoginForm

});

