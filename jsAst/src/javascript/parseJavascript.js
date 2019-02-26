//load(esprimaPath);
var ast = esprima.parseScript(code,{loc:true,comment:true});
var ast_with_parents = addParents(ast,"parent");
var string = JSON.stringify(ast_with_parents);