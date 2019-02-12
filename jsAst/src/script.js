load('https://unpkg.com/esprima@~4.0/dist/esprima.js');
ast = esprima.parseScript('const answer = 42')
print(JSON.stringify(ast, null, 2))