var ast = esprima.parseScript(code,{loc:true,comment:true});
var string = JSON.stringify(ast);