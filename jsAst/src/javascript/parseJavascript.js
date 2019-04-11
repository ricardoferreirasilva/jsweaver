//load(esprimaPath);
print("START AST PARSING");
var ast = esprima.parseScript(code,{loc:true,comment:true});
print("AFTER AST PARSING");
var string = JSON.stringify(ast);
print("AFTER STRINGIFY");