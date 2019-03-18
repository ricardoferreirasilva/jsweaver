
var options = JSON.parse(OPTIONS);

var AST_PARSED = JSON.parse(AST_STRING)
var GENERATED_JS = escodegen.generate(AST_PARSED,options);