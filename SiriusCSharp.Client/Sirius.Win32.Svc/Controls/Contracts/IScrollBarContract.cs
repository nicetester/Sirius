﻿using System;
using System.ServiceModel;
namespace Sirius.Win32.Svc.Controls
{
    [ServiceContract(Namespace = "Sirius.Win32.Svc.Controls", Name="ScrollBar")]
    public interface IScrollBarContract
    {
        [OperationContract]
        double GetLowerBound([param: MessageParameter(Name = "hwnd")]int hwnd);
        [OperationContract]
        double GetPosition([param: MessageParameter(Name = "hwnd")]int hwnd);
        [OperationContract]
        double GetUpperBound([param: MessageParameter(Name = "hwnd")]int hwnd);
        [OperationContract]
        void SetPosition([param: MessageParameter(Name = "hwnd")]int hwnd, [param: MessageParameter(Name = "pos")]double pos);
    }
}