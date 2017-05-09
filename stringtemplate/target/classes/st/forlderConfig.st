{
  "type": "folder",
  "name": "aap-$appName$",
  "children": [
    {
      "name": "src",
      "children": [
        {
          "name": "main",
          "children": [
            {
              "name": "java",
              "children": [
                {
                  "name": "com",
                  "children": [
                    {
                      "name": "taobao",
                      "children": [
                        {
                          "name": "app",
                          "children": [
                            {
                              "name": "$appName$",
                              "children": [
                                {
                                  "name": "constant",
                                  "children": [
                                    {
                                      "name": "$appClassName$Constant.java",
                                      "type": "file",
                                      "template": "constant"
                                    },
                                    {
                                      "name": "$appClassName$IdentityConstant.java",
                                      "type": "file",
                                      "template": "identityConstant"
                                    }
                                  ]
                                },
                                {
                                  "name": "scenario",
                                  "children": [
                                    {
                                      "name": "$appClassName$ItemBizIdentity.java",
                                      "type": "file",
                                      "template": "itemBizIdentity"
                                    }
                                  ]
                                }
                              ]
                            }
                          ]
                        }
                      ]
                    }
                  ]
                }
              ]
            },
            {
              "name": "resources",
              "children": [
                {
                  "name": "compcheck-$appName$-item-100-config.json",
                  "type": "file",
                  "template": "compcheck-item-100-config"
                },
                {
                  "name": "compconfig-$appName$-item-100-config.json",
                  "type": "file",
                  "template": "compconfig-item-100-config"
                },
                {
                  "name": "identity-$appName$-item-100-config.json",
                  "type": "file",
                  "template": "identity-item-100-config"
                },
                {
                  "name": "publishconfig--$appName$-item-100-config.json",
                  "type": "file",
                  "template": "publishconfig-item-100-config"
                }
              ]
            }
          ]
        }
      ]
    },
    {
      "name": "pom.xml",
      "type": "file",
      "template": "pom"
    }
  ]
}