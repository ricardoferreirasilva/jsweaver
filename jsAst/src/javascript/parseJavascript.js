//load(esprimaPath);
var ast = esprima.parseScript(code)
var string = JSON.stringify(ast, null, 2)