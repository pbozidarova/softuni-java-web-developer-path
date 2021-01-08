function attachEventsListeners() {
    const unitConversions = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254,
    }

    let inputDistance = document.getElementById('inputDistance');
    let inputUnits = document.getElementById('inputUnits');
    
    let outputDistance = document.getElementById('outputDistance');
    let outputUnits = document.getElementById('outputUnits');

    document.getElementById('convert').addEventListener('click', convert(inputDistance.value, inputUnits.value, outputDistance, outputUnits.value));

    function convert(inDistance, inUnits, outDistance, outUnits) {
        outDistance.value = '';
        
        let inDistanceInMeters = inDistance * unitConversions[inUnits];

        outDistance.value = inDistanceInMeters / unitConversions[outUnits];
    }

}