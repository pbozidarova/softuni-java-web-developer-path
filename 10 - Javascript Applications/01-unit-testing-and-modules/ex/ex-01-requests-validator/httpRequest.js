// Write a function that validates an HTTP request object. The object has the properties method, uri, version and message. Your function will 
// receive the object as a parameter and has to verify that each property meets the following requirements:
// •	method - can be GET, POST, DELETE or CONNECT
// •	uri - must be a valid resource address or an asterisk (*); a resource address is a combination of alphanumeric characters and periods; 
// all letters are Latin; the URI cannot be an empty string
// •	version - can be HTTP/0.9, HTTP/1.0, HTTP/1.1 or HTTP/2.0 supplied as a string
// •	message - may contain any number or non-special characters;special characters are <, >, \, &, ', "
// If a request is valid, return it unchanged. 
// If any part fails the check, throw an Error with message "Invalid request header: Invalid {Method/URI/Version/Message}". 
// Replace the part in curly braces with the relevant word. Note that some of the properties may be missing, in which case the request is 
// invalid. Check the properties in the order in which they are listed above. If more than one property is invalid, throw an error for the 
// first encountered.
function httpRequest(request) {

  let methods = ["POST", "GET", "DELETE", "CONNECT"];
  let uriReg = /^([A-Za-z0-9.]+)$|\*/g;
  let versions = ["HTTP/0.9", "HTTP/1.0", "HTTP/1.1", "HTTP/2.0"];
  let messageReg = /^([^<>\\&'"]*)$/g;

  if (!request.hasOwnProperty('method') || !methods.includes(request.method)) {
    throw new Error("Invalid request header: Invalid Method");
  }

  if (!request.hasOwnProperty('uri') || !request.uri.match(uriReg)) {
    throw new Error("Invalid request header: Invalid URI");
  }

  if (!request.hasOwnProperty('version') || !versions.includes(request.version)) {
    throw new Error("Invalid request header: Invalid Version");
  }

  if (!request.hasOwnProperty('message') || !request.message.match(messageReg)) {
    throw new Error("Invalid request header: Invalid Message");
  }

  console.log(request);
}

httpRequest({
  method: "GET",
  uri: "svn.public.catalog",
  version: "HTTP/1.1",
  message: "",
});

// httpRequest({
//   method: "OPTIONS",
//   uri: "git.master",
//   version: "HTTP/1.1",
//   message: "-recursive",
// });

// httpRequest({
//   method: "POST",
//   uri: "home.bash",
//   message: "rm -rf /*",
// });
