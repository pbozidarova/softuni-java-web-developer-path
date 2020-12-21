// Create a program for managing bug reports. It must perform as a self-contained module with exposed functionality. 
// Whenever a new element is added, deleted or changed with a command, the HTML should be updated automatically. A bug report has 
// the following structure:
// { ID: Number,
//   author: String,
//   description: String,
//   reproducible: Boolean,
//   severity: Number,
//   status: String }
// The ID of each report has to be a unique number, starting from zero and increasing sequentially. The module needs to implement 
// the following functions:
// •	report(author, description, reproducible, severity) - create a new bug report and store it. The ID is assigned automatically 
//     to the next available number and the status defaults to 'Open'
// •	setStatus(id, newStatus) - change the status of a bug registered in the system to newStatus by given ID
// •	remove(id) - delete a bug report by given ID
// •	sort(method) - change the order in which bug reports are displayed on the webpage. The method argument is a string and can be 
//     either 'author', 'severity' or 'ID'. Always sort in ascending order (default behavior for alphabetical sort). The default sorting 
//     method is by 'ID'.
// •	output(selector) - set the HTML element inside which the result is to be displayed to selector

function result() {
    let htmlReport = (id, description, author, status, severity) => { 
        
        return `<div id="report_${id}" class="report">
                            <div class="body">
                            <p>${description}</p>
                            </div>
                            <div class="title">
                            <span class="author">Submitted by: ${author}</span>
                            <span class="status">${status} | ${severity}</span>
                            </div>
                        </div>
                        `};

    let obj = {
        reports: [],
        report: function(author, description, reproducible, severity) {
            this.reports.push ({ id: this.reports.length + 1,
                author,
                description,
                reproducible,
                severity,
                status: 'Open'});

                this.render();              
        },
        setStatus: function(id, newStatus) {
            let reportWithOldStatus = this.reports.find(report => report.id == id);
            reportWithOldStatus.status = newStatus;
            
            this.render();
        },
        
        remove: function(id) {
            let reportToBeRemoved = this.reports.find(report => report.id == id);
            let index = this.reports.indexOf(reportToBeRemoved);
            
            this.reports.splice(index, 1);
            
            this.render();
        },
        
        sort: function( method ) {
            this.reports.sort( (a, b) => a[method] - b[method] || a[method].localeCompare(b[method]) );
            this.render();
        },
        
        output: function(selector) {return document.getElementById(selector.replace('#'));
        },
        
        render: function() {
            
            this.reports.forEach( report => this.output.innerHTML = htmlReport(report.id, 
                                                                            report.description, 
                                                                            report.author, 
                                                                            report.status, 
                                                                            report.severity )  );
        }
    }   
    
    return obj;
}

let tracker = result();
tracker.output('#content');
tracker.report('kiwi', 'judge rip', true, 5);
console.log(tracker);