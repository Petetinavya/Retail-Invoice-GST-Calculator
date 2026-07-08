let cart=[];function add(){let[v,p,g]=item.value.split(",");let q=+qty.value,d=+disc.value;let amt=p*q;let net=amt-amt*d/100;cart.push({v,amt,net,g:+g});let r=t.insertRow();r.insertCell().innerText=v;r.insertCell().innerText=amt.toFixed(2);r.insertCell().innerText=net.toFixed(2);}function bill(){let sub=cart.reduce((a,b)=>a+b.net,0),c=Math.min(+coupon.value,sub),taxable=sub-c,gst=0;cart.forEach(i=>gst+=taxable*(i.net/sub)*i.g/100);let cg=gst/2,sg=gst/2,fin=taxable+gst,round=Math.round(fin);out.textContent=`Subtotal: ₹${sub.toFixed(2)}
Coupon: ₹${c.toFixed(2)}
Taxable: ₹${taxable.toFixed(2)}
GST: ₹${gst.toFixed(2)}
CGST: ₹${cg.toFixed(2)}
SGST: ₹${sg.toFixed(2)}
Final: ₹${fin.toFixed(2)}
Rounded: ₹${round}
Adjustment: ₹${(round-fin).toFixed(2)}`;}